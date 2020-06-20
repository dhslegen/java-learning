package javaStudy.tools.mybatis.service.impl;

import javaStudy.tools.mybatis.entity.Medicine;
import javaStudy.tools.mybatis.mapper.MedicineMapper;
import javaStudy.tools.mybatis.service.IMedicineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-20
 */
@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine> implements IMedicineService {

}
