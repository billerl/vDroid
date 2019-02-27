package io.horizontalsystems.bitcoinkit.message

import io.horizontalsystems.bitcoinkit.core.toHexString
import io.horizontalsystems.bitcoinkit.network.messages.TransactionMessage
import org.junit.Assert.assertEquals
import org.junit.Test

class TransactionMessageTest {

    @Test
    fun createWithPayload() {
        val data = byteArrayOf(1, 0, 0, 0, 4, -21, -95, 5, -116, -111, -24, -127, -21, 122, 76, -17, -101, -8, 124, 127, -71, -124, 104, 44, 34, 6, 66, -17, -48, 97, -107, -47, 89, 108, -37, -77, -91, 0, 0, 0, 0, 107, 72, 48, 69, 2, 33, 0, -16, -94, -126, 77, -109, 26, -126, -83, 15, -15, 109, -17, 70, 22, -2, -85, -98, 67, 19, 64, 97, -123, -97, 111, -14, -108, 25, 79, 31, 45, 51, 52, 2, 32, 69, -36, -69, 60, -51, 8, 113, -120, 60, -104, -22, 62, -8, -55, 19, 10, 82, -96, -87, 28, 105, 116, 81, -89, 61, 127, 100, 35, 67, 22, -78, -94, 1, 33, 2, 81, 118, -65, 71, 110, 27, 65, -22, -26, 75, 109, -21, 27, 44, 29, 53, 0, -111, 15, -123, 7, -8, 35, -37, -88, 46, 24, 84, 84, -89, 108, -117, -1, -1, -1, -1, 90, 42, -116, -112, -90, -97, 92, 12, -89, 71, -17, 25, -98, 71, 103, -58, 16, 75, -84, 78, -48, 117, 66, 60, 111, -80, 10, 113, 14, 77, -80, 57, 1, 0, 0, 0, 106, 71, 48, 68, 2, 32, 123, -126, 57, 20, -69, 27, -58, -98, 114, 48, -94, -59, 92, 13, 48, -42, 4, -38, -101, 22, 92, 35, 57, 123, 31, 45, -89, -75, 42, 115, 33, -38, 2, 32, 4, -92, 93, 23, 51, 119, 92, 100, 30, 101, -18, -29, -47, -119, 57, -128, -128, 98, -53, 107, 117, 108, 100, -34, 110, 4, -60, -68, -47, 87, 13, -67, 1, 33, 2, 81, 118, -65, 71, 110, 27, 65, -22, -26, 75, 109, -21, 27, 44, 29, 53, 0, -111, 15, -123, 7, -8, 35, -37, -88, 46, 24, 84, 84, -89, 108, -117, -1, -1, -1, -1, -16, -62, -90, -63, -100, 89, 15, -63, 69, -61, 60, -38, -108, 24, -16, 42, 46, 86, 124, 115, -32, -87, 57, 85, -68, 23, 77, -103, -71, 95, -68, -37, 1, 0, 0, 0, 106, 71, 48, 68, 2, 32, 125, 71, -29, 23, -121, -79, -24, 60, -29, 58, 43, 29, 78, -90, -63, -47, -63, -99, 71, -20, -99, 70, -42, -26, -69, -15, -16, -89, 127, -63, -9, -42, 2, 32, 29, 17, 34, -113, -107, 108, -88, -117, -91, 119, -49, 36, 9, -126, -17, -87, 22, 49, 15, -19, -117, -109, -38, -40, 2, 54, 17, 80, -24, -114, 78, -116, 1, 33, 2, -68, -108, -4, 15, -20, -121, -84, -51, 73, 3, -24, 13, 6, -81, -79, 18, -92, 111, 116, 62, -103, 122, -14, -57, 104, 0, 53, -53, -90, -44, -77, -116, -1, -1, -1, -1, 121, 109, -40, -2, -112, -93, -10, -104, 15, 83, 121, -5, -77, -107, 44, -5, -87, 74, -79, 38, -33, -59, -38, 84, -19, 5, 14, 84, -31, -93, 9, 90, 4, 0, 0, 0, 106, 71, 48, 68, 2, 32, 11, -72, 121, 89, 104, -128, -34, -44, -14, -91, 56, -96, -103, -89, -7, -9, 123, 16, -48, -68, 85, -103, 105, -120, -16, -111, -82, 106, 65, 56, -122, -26, 2, 32, 85, 62, 70, 9, 2, 15, -78, -63, -90, -43, -52, -98, 63, -1, -120, -34, 5, -48, -68, 34, 76, 62, -118, -63, -1, 73, 34, -38, -125, 66, 50, -47, 1, 33, 2, -68, -108, -4, 15, -20, -121, -84, -51, 73, 3, -24, 13, 6, -81, -79, 18, -92, 111, 116, 62, -103, 122, -14, -57, 104, 0, 53, -53, -90, -44, -77, -116, -1, -1, -1, -1, 8, -76, 33, -87, 3, 0, 0, 0, 0, 23, -87, 20, -1, -11, -55, 35, 71, -41, -55, -92, 53, -42, -127, 96, -121, -65, 100, -88, 124, 26, -128, -73, -121, 106, 44, 5, 1, 0, 0, 0, 0, 23, -87, 20, 114, 105, -67, 118, 64, 11, -58, 34, 36, -23, -121, 60, 59, -23, -84, -87, 86, 105, 51, -24, -121, 121, 115, 63, 0, 0, 0, 0, 0, 23, -87, 20, -10, -19, 51, -75, 48, -85, 4, 73, -115, 49, 36, -40, -20, -73, 68, -22, -4, 20, -117, 101, -121, -74, -118, 25, 1, 0, 0, 0, 0, 23, -87, 20, -42, 58, 41, 64, -56, 39, 21, 74, -58, 71, -75, 47, 86, -17, 84, 117, -87, -9, 44, 42, -121, -64, 25, 43, 0, 0, 0, 0, 0, 23, -87, 20, -107, -79, -123, -126, 126, 84, 71, -92, -102, 36, 65, 70, 88, -50, 96, -34, 29, -47, 108, 38, -121, 18, -30, 66, 0, 0, 0, 0, 0, 25, 118, -87, 20, 23, 28, 60, -125, 83, -98, -36, -40, 73, -35, -8, -91, 77, 88, 21, -49, -103, 28, 66, 2, -120, -84, -75, 31, -26, 60, 0, 0, 0, 0, 25, 118, -87, 20, -79, -61, 108, -37, -56, 72, -120, 40, -3, -9, -59, 26, 1, -1, -36, 95, -83, 121, 95, 63, -120, -84, 22, -90, -65, 0, 0, 0, 0, 0, 23, -87, 20, -91, 98, 4, -64, -84, -46, -49, 3, 110, 3, 117, 110, 127, 114, -42, -81, -99, 10, 21, -71, -121, 0, 0, 0, 0)

        val expectedTransactionHex = "6ad4070a0d7a14ac75d47373f5bbddf3efd8db7b14789ec08abe487b1a763889"

        val message = TransactionMessage(data)
        val transaction = message.transaction

        assertEquals(expectedTransactionHex, transaction.hash.toHexString())
    }

}
