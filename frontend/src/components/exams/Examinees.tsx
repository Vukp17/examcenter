import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import ApiService from "../../services/ApiService";
import { Form, Button, Table } from "react-bootstrap";

export default function Examinees() {
  const [firstName, setfirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [dateOfBirth, setdateOfBirth] = useState("");
  const [adress, setadress] = useState("");
  const [examinees, setExaminees] = useState([]);
  const [needsUpdate, setNeedsUpdate] = useState(false);

  function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault();
    const person = { firstName, lastName, dateOfBirth, adress };
    ApiService.addExaminee(person)
      .then(() => {
        setfirstName("");
        setLastName("");
        setdateOfBirth("");
        setadress("");
        setNeedsUpdate(true); // update the state to refresh the table
      })
      .catch((error) => {
        console.error("Failed to add examinee:", error);
      });
  }

  useEffect(() => {
    async function fetchExaminees() {
      try {
        const data = await ApiService.getExaminees();
        setExaminees(data);
      } catch (error) {
        console.log(error);
      }
    }
    fetchExaminees();
  }, [needsUpdate]);

  function handleDelete(id: number) {
    setNeedsUpdate(false);
    ApiService.deleteExaminee(id)
      .then(() => {
        setNeedsUpdate(true);
      })
      .catch((error) => {
        console.error("Failed to delete examinee:", error);
      });
  }

  return (
    <div
      style={{ display: "flex", flexDirection: "column", alignItems: "center" }}
    >
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="formFirstName">
          <Form.Label>First Name:</Form.Label>
          <Form.Control
            type="text"
            value={firstName}
            onChange={(e) => setfirstName(e.target.value)}
          />
        </Form.Group>

        <Form.Group controlId="formLastName">
          <Form.Label>Last Name:</Form.Label>
          <Form.Control
            type="text"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
          />
        </Form.Group>

        <Form.Group controlId="formDateOfBirth">
          <Form.Label>Date of Birth:</Form.Label>
          <Form.Control
            type="date"
            value={dateOfBirth}
            onChange={(e) => setdateOfBirth(e.target.value)}
          />
        </Form.Group>

        <Form.Group controlId="formadress">
          <Form.Label>adress:</Form.Label>
          <Form.Control
            type="text"
            value={adress}
            onChange={(e) => setadress(e.target.value)}
          />
        </Form.Group>

        <div style={{ display: "flex", justifyContent: "center" }}>
          <Button variant="primary" type="submit">
            Add Person
          </Button>
        </div>
      </Form>
      <Table style={{ marginTop: "20px" }}>
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
            <th>adress</th>
          </tr>
        </thead>
        <tbody>
          {examinees.map((examinee) => (
            <tr key={examinee.id}>
              <td>{examinee.firstName}</td>
              <td>{examinee.lastName}</td>
              <td>{examinee.dateOfBirth}</td>
              <td>{examinee.adress}</td>
              <td>
                <button onClick={() => handleDelete(examinee.id)}>
                  <i className="fa fa-trash"></i> Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
}
