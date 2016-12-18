package info.nightscout.android.medtronic.message;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import info.nightscout.android.medtronic.MedtronicCnlSession;
import info.nightscout.android.medtronic.exception.ChecksumException;
import info.nightscout.android.medtronic.exception.EncryptionException;

/**
 * Created by lgoedhart on 27/03/2016.
 */
public class PumpBasalPatternResponseMessage extends MedtronicSendMessageResponseMessage {
    protected PumpBasalPatternResponseMessage(MedtronicCnlSession pumpSession, byte[] payload) throws EncryptionException, ChecksumException {
        super(pumpSession, payload);

        // TODO - determine message validity
        /*
        if (response.encode().length < (61 + 8)) {
            // Invalid message.
            // TODO - deal with this more elegantly
            Log.e(TAG, "Invalid message received for getBasalPatterns");
            return;
        }
        */

        // FIXME - this needs to go into PumpBasalPatternResponseMessage
        ByteBuffer basalRatesBuffer = ByteBuffer.allocate(96);
        basalRatesBuffer.order(ByteOrder.BIG_ENDIAN);
        basalRatesBuffer.put(this.encode(), 0x39, 96);

    }

}
