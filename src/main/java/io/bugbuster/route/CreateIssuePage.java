package io.bugbuster.route;

import io.bugbuster.BugListConfigurationModel;
import io.bugbuster.PageUtils;
import org.apache.commons.io.FileUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class CreateIssuePage implements Route {
    public Object handle(Request request, Response response) {

        String appname = null;
        try {
            appname = URLDecoder.decode(request.params("appname"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return PageUtils.HEADER +
                "" +
                "<br />" +
                "<section>" +
                PageUtils.form("post", "/create-issue/" + appname,
                        "<input name=\"title\" style=\"width:50.48em\" placeholder=\"title\" /><br />",
                        "<textarea name=\"description\" style=\"width:50.48em\"  placeholder=\"Description\"></textarea>",
                        "<input name=\"tags\"  placeholder=\"Comma separated tags\"/>",
                        "<br />",
                        "<br />",
                        "<button type='submit'>Create Issue</button>") +
                "</section>";
    }
}
