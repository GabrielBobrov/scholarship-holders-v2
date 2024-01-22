package com.scholarshipholders.entrypoint;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class UrlConstant {
    public static final String SCHOLAR_URI = "/scholars";
    public static final String BANK_URI = "/banks";

    public static final String PAYMENT_URI = "/scholars/{scholarId}/payments";

}
