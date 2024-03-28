package models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {


    String userID,
            password,
            firstName,
            lastName,
            email,
            phone,
            address1,
            address2,
            city,
            state,
            zip,
            country;

}
