package br.com.carlosjunior.smartparking.utils;


import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class MessagesExceptions {
    public static final String FIELD_NOTFOUND = "%s not found";

    public static final String FIELD_MANDATORY = "%s is mandatory";

    public static final String PARKING_SPACE = "Parking space: %s";

    public static final String VEHICLE_NOT_COMPATIBLE_WITH_PARKING_SPACE = "Vehicle not compatible with Parking Space";
    public static final String VEHICLE_REGISTRED_IN_PARKING_SPACE = "Veiculo já cadastrado para esta vaga";
    public static final String PARKING_SPACE_IN_USE = "Vaga está em uso";
}
