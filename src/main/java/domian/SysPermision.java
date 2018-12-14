package domian;

import lombok.Data;

@Data
public class SysPermision {
    private Long id;

    private String pname;

    private String type;

    private String url;

    private String precode;

    private Long parentid;

    private String parentids;
}