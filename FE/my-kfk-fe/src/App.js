import "./App.css";

function App() {
  const sendMessage = async (message) => {
    await fetch("http://localhost:8080/events", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        topic: "my-topic",
        message: message,
      }),
    });
  };

  const sendDirectMessage = async (message) => {
    await fetch("http://localhost:8080/direct", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        topic: "my-topic",
        message: message,
      }),
    });
  };

  return (
    <div className="App">
      <header className="App-header">
        <h2>Kafka 메시지 전송</h2>
        <div className="button-container">
          <button
            className="kafka-button"
            onClick={() => sendMessage("message1")}
          >
            메시지1 보내기 (REST Proxy)
          </button>

          <button
            className="kafka-button"
            onClick={() => sendMessage("message2")}
          >
            메시지2 보내기 (REST Proxy)
          </button>

          <button
            className="kafka-button"
            onClick={() => sendDirectMessage("message3")}
          >
            메시지3 보내기 (Spring Kafka)
          </button>
        </div>
      </header>
    </div>
  );
}

export default App;
