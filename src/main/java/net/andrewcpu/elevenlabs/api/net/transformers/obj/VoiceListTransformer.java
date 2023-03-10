package net.andrewcpu.elevenlabs.api.net.transformers.obj;

import net.andrewcpu.elevenlabs.api.net.transformers.ResultTransformerAdapter;
import net.andrewcpu.elevenlabs.elements.voice.Voice;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VoiceListTransformer extends ResultTransformerAdapter<List<Voice>> {
	@Override
	public List<Voice> transform(JSONObject object) {
		JSONArray voiceArray = (JSONArray) object.get("voices");
		List<Voice> voices = new ArrayList<>();

		for (Object o : voiceArray) {
			JSONObject voiceJson = (JSONObject) o;
			voices.add(Voice.fromJSON(voiceJson));
		}

		return voices;
	}
}
