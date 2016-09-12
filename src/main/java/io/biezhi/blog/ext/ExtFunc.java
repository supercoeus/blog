package io.biezhi.blog.ext;

import com.blade.kit.DateKit;
import jetbrick.template.JetAnnotations;

/**
 * Created by oushaku on 16/9/10.
 */
@JetAnnotations.Functions
public class ExtFunc {

    public static String date(int unixTime){
        return DateKit.formatDateByUnixTime(unixTime, "yyyy-MM-dd");
    }

}
