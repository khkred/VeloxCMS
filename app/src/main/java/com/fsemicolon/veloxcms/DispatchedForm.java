package com.fsemicolon.veloxcms;

public class DispatchedForm {

    private String mDispatchDate, mDispatchTime,mDHddSno,mDHddSize,mDAuthorisedAgent;

    public DispatchedForm(String dispatchDate, String dispatchTime, String DHddSno, String DHddSize, String DAuthorisedAgent) {
        mDispatchDate = dispatchDate;
        mDispatchTime = dispatchTime;
        mDHddSno = DHddSno;
        mDHddSize = DHddSize;
        mDAuthorisedAgent = DAuthorisedAgent;
    }


    public String getDispatchDate() {
        return mDispatchDate;
    }

    public void setDispatchDate(String dispatchDate) {
        mDispatchDate = dispatchDate;
    }

    public String getDispatchTime() {
        return mDispatchTime;
    }

    public void setDispatchTime(String dispatchTime) {
        mDispatchTime = dispatchTime;
    }

    public String getDHddSno() {
        return mDHddSno;
    }

    public void setDHddSno(String DHddSno) {
        mDHddSno = DHddSno;
    }

    public String getDHddSize() {
        return mDHddSize;
    }

    public void setDHddSize(String DHddSize) {
        mDHddSize = DHddSize;
    }

    public String getDAuthorisedAgent() {
        return mDAuthorisedAgent;
    }

    public void setDAuthorisedAgent(String DAuthorisedAgent) {
        mDAuthorisedAgent = DAuthorisedAgent;
    }
}
