
import base.SetBaseServer;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static io.restassured.RestAssured.given;

/**
 * Created by Administrator on 2017/4/18.
 */
@Features("保单")

@Title("共管保单相关接口")
public class JdSharePolicyTest extends SetBaseServer {
    private String token = null;
    private String loginNo = super.loginNo;


    @Before
    public void setUp() throws Exception {
        //getUserToken(loginNo);
       // USRTOKEN = WriteAndReadFile.readFile(loginNo + "_AccessToken.json");
        token = getSaveData(loginNo + "accessToken").toString();

    }

    @Stories("查询接口")
    @Title("分页查询用户共管保单接口")
    @Description("默认查询")
    @Test
    public void getUserSharePolicyTest() throws Exception {
        given().
                contentType(ContentType.JSON).
                header("Authorization",token).
        when().
                get("/jiadao/api/sharedJdPolicy").
        then().
                statusCode(200);
    }

    @Stories("查询接口")
    @Title("查询用户保单")
    @Description("默认查询用户保单数据")
    @Test
    public void getUserPolicyTest() throws Exception {
        given().
                contentType(ContentType.JSON).
                header("Authorization",token).
        when().
                get("/jiadao/api/jdPolicy").
        then().
                statusCode(200);
    }
}
