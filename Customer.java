import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.Gson;

public class Customer {
	public static void main(String[] args) throws IOException,InterruptedException {
		
		String id = args.length > 0 ? args[0] : "1";

		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder().GET()
                           .uri(URI.create("https://jsonplaceholder.typicode.com/todos/"+id)).build();

		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		System.out.println(response.statusCode());
		System.out.println(response.body());
		
		Todo todo = new Gson().fromJson(response.body(),Todo.class);
		System.out.println(todo);
	}
}

public class Todo {
	private Integer id, userId;
	private String title;
	private Boolean completed;

	public void setId(Integer id) {	this.id = id;}
	public void setUserId(Integer userId) {	this.userId = userId;}
	public void setTitle(String title) {this.title = title;}
	public void setCompleted(Boolean completed) {this.completed = completed;}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", userId=" + userId + ", title=" + title + ", completed=" + completed + "]";
	}
}
