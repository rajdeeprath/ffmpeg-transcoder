package com.flashvisions.server.rtmp.transcoder.handler;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.commons.exec.LogOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flashvisions.server.rtmp.transcoder.interfaces.TranscodeSessionDataCallback;
import com.flashvisions.server.rtmp.transcoder.pojo.Session;


public class TranscodeSessionOutputStream extends LogOutputStream {

	private static Logger logger = LoggerFactory.getLogger(Session.class);
	private TranscodeSessionDataCallback callback;
	private static final int QUEUE_SIZE = 10;
	private final Queue<String> lines = new LinkedList<String>();
	private long lastOutputTime = 0;
	
	public long getLastOutputTime() {
		return lastOutputTime;
	}

	public void setLastOutputTime(long lastOutputTime) {
		this.lastOutputTime = lastOutputTime;
	}

	public TranscodeSessionOutputStream(){
		
	}
	
	public TranscodeSessionOutputStream(TranscodeSessionDataCallback callback){
		this.callback = callback;
	}
	
	@Override
	protected void processLine(String line, int level) {
		
		logger.info(line);
		
		if(lines.size()>QUEUE_SIZE)
		lines.remove();
		
		lines.add(line);
		lastOutputTime = System.currentTimeMillis();
		
		if(this.callback != null){
		if(lines.size() == 1) this.callback.onTranscodeProcessStart(lastOutputTime);
		this.callback.onTranscodeProcessData(line, lastOutputTime);
		}
	}
	
	/* Estimates if process is running by checking if there was output in last 5 seconds */
	public boolean isRunning()
	{
		long diff = System.currentTimeMillis() - lastOutputTime;
        long diffSeconds = diff / 1000 % 60;
        return (diffSeconds>5)?false:true;
	}
	
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		logger.info("closing output stream");
		super.close();
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		super.flush();
	}

	@Override
	public int getMessageLevel() {
		// TODO Auto-generated method stub
		return super.getMessageLevel();
	}

	@Override
	protected void processBuffer() {
		// TODO Auto-generated method stub
		super.processBuffer();
	}

}
