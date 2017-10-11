package com.sramanopasaka.sipanionline.sadhumargi.cms.response;

import com.sramanopasaka.sipanionline.sadhumargi.model.Business;
import com.sramanopasaka.sipanionline.sadhumargi.model.DharmicData;

import java.util.List;

/**
 * Name    :   pranavjdev
 * Date   : 8/14/17
 * Email : pranavjaydev@gmail.com
 */

public class DharmikDetailsResponse extends GUIResponse{

    private boolean statusCode = false;
    @Override
    public boolean isStatus() {
        return statusCode;
    }

    @Override
    public void setStatus(boolean status) {
        this.statusCode = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status = null;

    private String message = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    private DharmicData data = null;

    public DharmicData getData() {
        return data;
    }

    public void setData(DharmicData data) {
        this.data = data;
    }
}
