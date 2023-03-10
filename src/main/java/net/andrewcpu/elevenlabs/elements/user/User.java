package net.andrewcpu.elevenlabs.elements.user;

import net.andrewcpu.elevenlabs.ElevenLabsAPI;
import net.andrewcpu.elevenlabs.api.HistoryAPI;
import net.andrewcpu.elevenlabs.api.UserAPI;
import net.andrewcpu.elevenlabs.elements.voice.History;
import net.andrewcpu.elevenlabs.exceptions.ElevenLabsException;
import org.json.simple.JSONObject;


public class User {
	private final Subscription subscription;
	private final boolean isNewUser;
	private final String apiKey;

	public static User get() throws ElevenLabsException {
		return UserAPI.getUser();
	}

	public User(Subscription subscription, boolean isNewUser, String xiApiKey) {
		this.subscription = subscription;
		this.isNewUser = isNewUser;
		this.apiKey = xiApiKey;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public boolean isNewUser() {
		return isNewUser;
	}

	public String getAPIKey() {
		return apiKey;
	}

	public History getHistory() throws ElevenLabsException {
		return HistoryAPI.getHistory();
	}
	public static User fromJSON(JSONObject object) {
		JSONObject subscriptionJson = (JSONObject) object.get("subscription");
		Subscription subscription = Subscription.fromJSON(subscriptionJson);
		boolean isNewUser = (boolean) object.get("is_new_user");
		String xiApiKey = (String) object.get("xi_api_key");
		return new User(subscription, isNewUser, xiApiKey);
	}

	@Override
	public String toString() {
		return "User{" +
				"subscription=" + subscription +
				", isNewUser=" + isNewUser +
				", apiKey='" + apiKey + '\'' +
				'}';
	}
}
