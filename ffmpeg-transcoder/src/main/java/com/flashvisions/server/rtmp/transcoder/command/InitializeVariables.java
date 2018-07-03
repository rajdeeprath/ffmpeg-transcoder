package com.flashvisions.server.rtmp.transcoder.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flashvisions.server.rtmp.transcoder.TranscodeSessionManager;
import com.flashvisions.server.rtmp.transcoder.context.TranscoderContext;
import com.flashvisions.server.rtmp.transcoder.exception.TranscoderException;
import com.flashvisions.server.rtmp.transcoder.interfaces.ITranscodeSessionManager;
import com.flashvisions.server.rtmp.transcoder.system.Globals;


public class InitializeVariables implements Command {

	private static Logger logger = LoggerFactory.getLogger(InitializeVariables.class);
	
	@Override
	public boolean execute(Context context) throws Exception {
		
		logger.info("Initialize Variables");
		
		try
		{
			TranscoderContext ctx = (TranscoderContext) context;
			
			logger.debug("Persist verified env variables");
			Globals.addEnv("ffmpeg_path", ctx.getFFmpegPath());
			Globals.addEnv("ffmpeg_version", ctx.getFfmpegVersion());
			Globals.addEnv("transcoder_templates_path", ctx.getTemplateDirectory());
			
			logger.debug("Initialize transcode manager");
			ITranscodeSessionManager manager = TranscodeSessionManager.getInstance();
		}
		catch(Exception e)
		{
			logger.error("Transcoder initialization failed " + e.getMessage());
			throw new TranscoderException(e);
		}
		
		return false;
	}
}
