package io.bugbuster.route;

import io.bugbuster.BugListConfigurationModel;
import io.bugbuster.PageUtils;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.File;

public class CreateApp implements Route {
    public Object handle(Request request, Response response) {
        String appName = request.params("appname");

        if (appName == null) {
            String appname = request.queryParams("appname");
            String bugBusterHome = BugListConfigurationModel.BUG_BUSTER_HOME + "/" + appname;
            System.out.println(bugBusterHome);
            File appBugDir = new File(bugBusterHome);
            boolean mkdir = appBugDir.mkdir();

            if (mkdir) {
                response.redirect("/app/" + appname);
            }
            return PageUtils.HEADER + mkdir;
        } else {
            response.status(404);
            return "Cannot create";
        }
    }
}
