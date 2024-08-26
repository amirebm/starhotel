import React, { useState } from "react";
import { addRoom } from "./ApiFunctions"; // Adjust the path as necessary

const TestAddRoom = () => {
  const [result, setResult] = useState(null);
  const [error, setError] = useState(null);

  const handleAddRoom = async () => {
    const photo = new Blob(["test photo"], { type: "image/jpeg" }); // Mock photo
    const roomType = "Deluxe";
    const roomPrice = "200";

    try {
      // const success = await addRoom(photo, roomType, roomPrice);
      setResult(success ? "Room added successfully." : "Failed to add room.");
    } catch (err) {
      setError(`Error occurred: ${err.message}`);
    }
  };

  return (
    <div>
      <h1>Test Add Room</h1>
      <button onClick={handleAddRoom}>Add Room</button>
      {result && <p>{result}</p>}
      {error && <p style={{ color: "red" }}>{error}</p>}
    </div>
  );
};

export default TestAddRoom;
