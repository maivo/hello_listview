package pee.hellolistview.mb;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.ResponseHandlerInterface;
import com.x5.template.Chunk;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

import pee.hellolistview.ui.AppSession;
import pee.hellolistview.util.AssetUtils;

/**
 * Created by pvu_asus on 28/05/2015.
 */
public class MbClient {
    private static final String TAG = "MbClient";

    private static final String BASE_URL ="http://172.20.10.4:8080/mbmock";



    public static String getSsGetMultifactorSecurityInfoRequestXml(Context context, String userName, String password){
        String assetPath = "mb_securityService/securityService_getMultifactorSecurityInfo_request.cxml";
        String chunkTemplateContent = AssetUtils.getAssetContent(context, assetPath);

        //get result
        Chunk c = new Chunk();
        c.append(chunkTemplateContent);
        c.set("userName", userName);
        c.set("password", password);
        return c.toString();
    }




}
