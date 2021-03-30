package com.fsemicolon.veloxcms;

public class DispatchedForm {

    private String mDispatchedDate,mDispatchedTime,mDHddSnSize,mDAuthorisedAgent;

    public DispatchedForm(String dispatchedDate, String dispatchedTime, String DHddSnSize, String DAuthorisedAgent) {
        mDispatchedDate = dispatchedDate;
        mDispatchedTime = dispatchedTime;
        mDHddSnSize = DHddSnSize;
        mDAuthorisedAgent = DAuthorisedAgent;
    }

    public String getDispatchedDate() {
        return mDispatchedDate;
    }

    public void setDispatchedDate(String dispatchedDate) {
        mDispatchedDate = dispatchedDate;
    }

    public String getDispatchedTime() {
        return mDispatchedTime;
    }

    public void setDispatchedTime(String dispatchedTime) {
        mDispatchedTime = dispatchedTime;
    }

    public String getDHddSnSize() {
        return mDHddSnSize;
    }

    public void setDHddSnSize(String DHddSnSize) {
        mDHddSnSize = DHddSnSize;
    }

    public String getDAuthorisedAgent() {
        return mDAuthorisedAgent;
    }

    public void setDAuthorisedAgent(String DAuthorisedAgent) {
        mDAuthorisedAgent = DAuthorisedAgent;
    }
}
