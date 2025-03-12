package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account {

    private String accountName;
    private String webSite;
    private String type;
    private String description;
    private String phone;
}
