package br.com.carlosjunior.smartparking.utils;


import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class MessagesExceptions {
    public static final String FIELD_NOTFOUND = "%s not found";

    public static final String FIELD_MANDATORY = "%s is mandatory";

    public static final String ALREADY_REGISTERED = " %s already registered";

    public static final String PARKING_RECORD_STATUS = "Parking Record: %s";
}
