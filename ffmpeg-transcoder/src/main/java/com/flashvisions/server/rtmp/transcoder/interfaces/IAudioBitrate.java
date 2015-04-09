package com.flashvisions.server.rtmp.transcoder.interfaces;

public interface IAudioBitrate extends IPassThru, Cloneable {

	public int getBitrate();
	public void setBitrate(int bitrate);
}
