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
 * @since 2020-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PaymentNew implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pkNo;

    private Integer medicineDirectoryPkNo;

    private Integer newMedicineDirectoryPkNo;


}
