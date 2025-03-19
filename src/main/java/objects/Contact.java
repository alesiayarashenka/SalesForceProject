package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    private String contactLastName;
    private String contactFirstName;
    private String title;
    private String description;
    private String phone;
    private String email;
    private String salutation;
}
