package javaStudy.tools.mybatis;

import javaStudy.tools.mybatis.entity.HealthCareMedicineDirectoryOfficial;
import javaStudy.tools.mybatis.mapper.HealthCareMedicineDirectoryOfficialMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // 指定配置文件
        String resource = "javaStudy/tools/mybatis/mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        HealthCareMedicineDirectoryOfficialMapper healthCareMedicineDirectoryOfficialMapper = sqlSession.getMapper(HealthCareMedicineDirectoryOfficialMapper.class);
        List<HealthCareMedicineDirectoryOfficial> healthCareMedicineDirectoryOfficials = javaStudy.tools.excel解析.Main.parse("/Users/zhaowenhao/Documents/GitRepositories/document/普元公司/知识库/山东官方医保目录/副本西药部分.xlsx");
        List<HealthCareMedicineDirectoryOfficial> healthCareMedicineDirectoryOfficials1 = javaStudy.tools.excel解析.Main.parse1("/Users/zhaowenhao/Documents/GitRepositories/document/普元公司/知识库/山东官方医保目录/中成药部分.xlsx");
        for (HealthCareMedicineDirectoryOfficial healthCareMedicineDirectoryOfficial : healthCareMedicineDirectoryOfficials) {
            healthCareMedicineDirectoryOfficialMapper.save(healthCareMedicineDirectoryOfficial);
        }
        for (HealthCareMedicineDirectoryOfficial healthCareMedicineDirectoryOfficial : healthCareMedicineDirectoryOfficials1) {
            healthCareMedicineDirectoryOfficialMapper.save(healthCareMedicineDirectoryOfficial);
        }
    }

}
