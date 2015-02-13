package com.humoule.seekbartext;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class Utils
{

	/**
	 * This method converts dp unit to equivalent pixels, depending on device density.
	 * 
	 * @param dp
	 * @param context
	 * @return
	 */
	public static int convertDpToPixel(float dp, Context context)
	{
		Resources resources = context.getResources();
		DisplayMetrics metrics = resources.getDisplayMetrics();
		float px = dp * (metrics.densityDpi / 160f);
		return (int) px;
	}

}
