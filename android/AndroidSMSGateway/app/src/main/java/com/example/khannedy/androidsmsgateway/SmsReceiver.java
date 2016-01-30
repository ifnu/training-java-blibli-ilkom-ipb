package com.example.khannedy.androidsmsgateway;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.util.Objects;

/**
 * @author Eko Kurniawan Khannedy
 */
public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            // pesan sms masuk
            Object[] array = (Object[]) bundle.get("pdus");
            for (Object pdu : array) {
                SmsMessage message = SmsMessage.createFromPdu((byte[]) pdu);

                SmsRequest request = new SmsRequest();
                request.to = message.getOriginatingAddress();
                request.message = message.getMessageBody();

                ClientService.send(request);
            }
        }
    }
}
