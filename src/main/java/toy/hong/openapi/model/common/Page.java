package toy.hong.openapi.model.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page extends Search{
    private int pageNo = 1;
    private int pageSize = 10;
}
