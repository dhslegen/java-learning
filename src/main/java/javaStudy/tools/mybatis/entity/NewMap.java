package javaStudy.tools.mybatis.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NewMap implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer mapMedicinePkNo;

    private Integer mapDirectoryPkNo;

    private Integer newMapDirectoryPkNo;


}
