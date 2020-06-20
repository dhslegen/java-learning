package javaStudy.tools.mybatis.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HealthCareMedicineMap implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer medicinePkNo;

    private Integer healthCareMedicinePkNo;

    private String createdUser;

    private String updatedUser;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;


}
