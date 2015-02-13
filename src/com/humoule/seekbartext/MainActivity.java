package com.humoule.seekbartext;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity
{

	private SeekBar mSeekBar;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = getApplicationContext();

		mSeekBar = (SeekBar) findViewById(R.id.seekbar_radius);
		mSeekBar.setThumb(setSeekbarDrawableThumb("0"));
		mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
		{

			@Override
			public void onStopTrackingTouch(SeekBar seekBar)
			{

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar)
			{

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				int value = seekBar.getProgress();
				String valueString = String.valueOf(value);
				seekBar.setThumb(setSeekbarDrawableThumb(valueString));

			}
		});

	}

	private BitmapDrawable setSeekbarDrawableThumb(String text)
	{

		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.seeck_bar_full);
		Bitmap bmp = bitmap.copy(Bitmap.Config.ARGB_8888, true);
		Canvas c = new Canvas(bmp);
		Paint p = new Paint();
		p.setTypeface(Typeface.DEFAULT_BOLD);
		p.setTextSize(getResources().getDimension(R.dimen.seek_text));
		p.setColor(getResources().getColor(R.color.white));
		int width = (int) p.measureText(text);
		int yPos = Utils.convertDpToPixel(getResources().getDimension(R.dimen.text_seek_y), context);
		c.drawText(text, (bmp.getWidth() - width) / 2, (yPos), p);

		return new BitmapDrawable(getResources(), bmp);
	}

}
