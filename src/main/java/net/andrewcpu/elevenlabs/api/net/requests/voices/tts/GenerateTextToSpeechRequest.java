package net.andrewcpu.elevenlabs.api.net.requests.voices.tts;

import net.andrewcpu.elevenlabs.api.net.ElevenLabsRequest;
import net.andrewcpu.elevenlabs.api.net.requests.ElevenLabsPostRequest;
import net.andrewcpu.elevenlabs.api.net.transformers.FilePingPongTransformer;
import net.andrewcpu.elevenlabs.elements.voice.Voice;
import net.andrewcpu.elevenlabs.elements.voice.VoiceSettings;
import net.andrewcpu.elevenlabs.enums.HTTPMethod;
import net.andrewcpu.elevenlabs.enums.ResponseType;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.List;

@SuppressWarnings("unchecked")
public class GenerateTextToSpeechRequest extends ElevenLabsPostRequest<File> {

	private static JSONObject buildBody(VoiceSettings settings, String text){
		JSONObject object = new JSONObject();
		object.put("text", text);
		object.put("voice_settings", settings.toJSON());
		return object;
	}
	public GenerateTextToSpeechRequest(Voice voice, VoiceSettings settings, String text, File outputFile){
		super(List.of(voice.getVoiceId()), buildBody(settings, text), new FilePingPongTransformer(outputFile));
		responseType = (ResponseType.FILE_STREAM);
		outputFilePath = (outputFile);
	}

	@Override
	public String getEndpoint() {
		return "text-to-speech/{voiceId}";
	}
}
