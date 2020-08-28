package toy.hong.openapi.model.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Search {
    private int type = 0;
    private String keyword;
}
