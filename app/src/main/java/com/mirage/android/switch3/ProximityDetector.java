package com.mirage.android.switch3;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.util.Log;
import android.widget.Toast;

public class ProximityDetector extends BroadcastReceiver {

	private double longitude;

	private double latitude;

	private String name;

	private String profile;

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Log.d("onReceive", "in onReceive");

		String name, profile;
		Cursor c = null;

		// Key for determining whether user is leaving or entering
		String k = LocationManager.KEY_PROXIMITY_ENTERING;

		while (c.moveToNext()) {
			int longitude1 = c.getColumnIndex("longitude");
			int latitude1 = c.getColumnIndex("latitude");
			int name1 = c.getColumnIndex("name");
			int profile1 = c.getColumnIndex("profile");

			this.longitude = c.getDouble(longitude1);
			this.latitude = c.getDouble(latitude1);
			this.name = c.getString(name1);
			this.profile = c.getString(profile1);

			addProximityAlert(this.latitude, this.longitude, this.name,
					this.profile);
		}
		boolean state = intent.getBooleanExtra(k, false);

		// get the name and the profile for the location
		name = intent.getStringExtra("name");
		profile = intent.getStringExtra("profile");

		if (state) {
			// set the audio manager
			AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
			
			if (profile.equalsIgnoreCase("silent"))
				audioManager.setRingerMode(audioManager.RINGER_MODE_SILENT);
			
			else if (profile.equalsIgnoreCase("vibrate"))
				audioManager.setRingerMode(audioManager.RINGER_MODE_VIBRATE);
			
			else if (profile.equalsIgnoreCase("loud"))
				audioManager.setRingerMode(audioManager.RINGER_MODE_NORMAL);
			
			//Toast.makeText(context, name + " profile is active", 600).show();

		} else {
			// Other custom Notification
			Toast.makeText(context,"You are out of range" + name,Toast.LENGTH_SHORT).show();
		}

	}

	public void addProximityAlert(double latitude, double longitude,
								  String name, String profile) {

	}


	private void registerReceiver(ProximityDetector proximityDetector, IntentFilter filter) {
	}

}
