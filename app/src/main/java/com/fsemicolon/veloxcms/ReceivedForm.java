package com.fsemicolon.veloxcms;

import java.util.ArrayList;

public class ReceivedForm {

    private String mEncodingFor,mReceivedDate,mReceivedTime,mFilmName,mProductionCompany,mAuthorisedAgent,mReelFormat,mTotalDuration,mRHddSnSize;

    private ArrayList<String> mReelWiseDurations;

    public ReceivedForm(String encodingFor, String receivedDate, String receivedTime, String filmName, String productionCompany, String authorisedAgent, String reelFormat, String totalDuration, String RHddSnSize, ArrayList<String> reelWiseDurations) {
        mEncodingFor = encodingFor;
        mReceivedDate = receivedDate;
        mReceivedTime = receivedTime;
        mFilmName = filmName;
        mProductionCompany = productionCompany;
        mAuthorisedAgent = authorisedAgent;
        mReelFormat = reelFormat;
        mTotalDuration = totalDuration;
        mRHddSnSize = RHddSnSize;
        mReelWiseDurations = reelWiseDurations;
    }

    public String getEncodingFor() {
        return mEncodingFor;
    }

    public void setEncodingFor(String encodingFor) {
        mEncodingFor = encodingFor;
    }

    public String getReceivedDate() {
        return mReceivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        mReceivedDate = receivedDate;
    }

    public String getReceivedTime() {
        return mReceivedTime;
    }

    public void setReceivedTime(String receivedTime) {
        mReceivedTime = receivedTime;
    }

    public String getFilmName() {
        return mFilmName;
    }

    public void setFilmName(String filmName) {
        mFilmName = filmName;
    }

    public String getProductionCompany() {
        return mProductionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        mProductionCompany = productionCompany;
    }

    public String getAuthorisedAgent() {
        return mAuthorisedAgent;
    }

    public void setAuthorisedAgent(String authorisedAgent) {
        mAuthorisedAgent = authorisedAgent;
    }

    public String getReelFormat() {
        return mReelFormat;
    }

    public void setReelFormat(String reelFormat) {
        mReelFormat = reelFormat;
    }

    public String getTotalDuration() {
        return mTotalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        mTotalDuration = totalDuration;
    }

    public String getRHddSnSize() {
        return mRHddSnSize;
    }

    public void setRHddSnSize(String RHddSnSize) {
        mRHddSnSize = RHddSnSize;
    }

    public ArrayList<String> getReelWiseDurations() {
        return mReelWiseDurations;
    }

    public void setReelWiseDurations(ArrayList<String> reelWiseDurations) {
        mReelWiseDurations = reelWiseDurations;
    }
}
