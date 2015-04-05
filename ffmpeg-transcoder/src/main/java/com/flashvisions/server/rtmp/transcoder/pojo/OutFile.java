package com.flashvisions.server.rtmp.transcoder.pojo;

import com.flashvisions.server.rtmp.transcoder.interfaces.IFileOutput;

public class OutFile extends OutMedia implements IFileOutput {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2412359376247912111L;

	public OutFile(String source) {
		super(source);
	}
	
	public OutFile(String source, boolean isTemplate){
		super(source,isTemplate);
	}

	@Override
	public boolean isFile() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isStreamingMedia() {
		// TODO Auto-generated method stub
		return false;
	}

}
