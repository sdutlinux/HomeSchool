package com.linuxgroup.homeschool.client.request.job;

import com.linuxgroup.homeschool.client.App;
import com.linuxgroup.homeschool.client.api.UserApi;
import com.linuxgroup.homeschool.client.broadcast.BroadcastSender;
import com.linuxgroup.homeschool.client.db.dao.RecentChatDao;
import com.linuxgroup.homeschool.client.db.model.Person;
import com.linuxgroup.homeschool.client.db.model.RecentChat;
import com.linuxgroup.homeschool.client.db.service.DatabaseManager;
import com.path.android.jobqueue.Params;

/**
 * Created by tan on 14-10-23.
 */
public class FetchFriendInfoJob extends BaseJob {

    /**
     * 用于请求的 message 的 id
     */
    private Integer friendId;
    private String account;

    public FetchFriendInfoJob(Integer friendId) {
        super(new Params(Priority.LOW).requireNetwork().groupBy("fetch-friend-info"));

        this.friendId = friendId;
        this.account = null;

    }

    public FetchFriendInfoJob(String account) {
        super(new Params(Priority.LOW).requireNetwork().groupBy("fetch-friend-info"));

        this.account = account;
        this.friendId = null;
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        System.out.println("run Fetch message " + getId());

        // 判断是根据id获取还是根据帐号获取
        Person person = null;

        if (friendId != null) {
            person = UserApi.userInfo(friendId);
        } else {
            person = UserApi.userInfo(account);
        }

        System.out.println(person);

        //todo: 如果为空, 怎么处理?
        if (person == null) {

        }

        // 将 person 信息保存到本地
        DatabaseManager.getPersonDao().save(person);

        // 如果发现有 recentchat， 则需要更新该recentchat的信息
        RecentChatDao recentChatDao = DatabaseManager.getRecentChatDao();

        String friendAccount = person.getAccount();

        //todo: 这里有些问题，如果第一次创建 recnetChat 又没有个人信息，获取时不能保证已经创建了 RecentChat?
        RecentChat recentChat = recentChatDao.queryBy(getOwnerAccount(), friendAccount);
        if (recentChat != null) { // 找到了该 recentChat
            // 更新信息
            recentChat.setNick(person.getName());

            // 保存
            recentChatDao.saveRecentChat(recentChat);
        }

        // todo: 发送更新好友的广播
        BroadcastSender.sendUpdatePersonInfo(App.getContext());
    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
