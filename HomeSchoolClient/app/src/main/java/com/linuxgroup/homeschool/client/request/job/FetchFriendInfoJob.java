package com.linuxgroup.homeschool.client.request.job;

import com.linuxgroup.homeschool.client.api.UserApi;
import com.linuxgroup.homeschool.client.db.model.Person;
import com.path.android.jobqueue.Params;

/**
 * Created by tan on 14-10-23.
 */
public class FetchFriendInfoJob extends BaseJob {

    /**
     * 用于请求的 message 的 id
     */
    private Integer friendId;

    public FetchFriendInfoJob(Integer friendId) {
        super(new Params(Priority.LOW).requireNetwork().groupBy("fetch-friend-info"));

        this.friendId = friendId;
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        System.out.println("run Fetch message " + getId());

        Person person = UserApi.userInfo(friendId);

        // todo: 将 person 信息保存到本地

        System.out.println(person);

        // todo: 发送更新好友的广播


    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
