package com.sramanopasaka.sipanionline.sadhumargi.cms.response;

import com.sramanopasaka.sipanionline.sadhumargi.model.DharmicData;
import com.sramanopasaka.sipanionline.sadhumargi.model.SanghData;

/**
 * Name    :   pranavjdev
 * Date   : 8/14/17
 * Email : pranavjaydev@gmail.com
 */

public class SanghDetailsResponse extends GUIResponse{

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


    public SanghData getData() {
        return data;
    }

    public void setData(SanghData data) {
        this.data = data;
    }

    private SanghData data = null;

}
