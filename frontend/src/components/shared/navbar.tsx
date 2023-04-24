import React from "react";
import { Navbar, Nav } from "react-bootstrap";
import { Link } from "react-router-dom";

export default function Navigation() {
  return (
    <Navbar bg="light" expand="lg">
      <Navbar.Brand as={Link} to="/">Exam center</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
          <Nav.Link as={Link} to="/exams">Exams</Nav.Link>
          <Nav.Link as={Link} to="/exam-list">Examinees</Nav.Link>
          {/* <Nav.Link as={Link} to="#">Link 3</Nav.Link> */}
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
}
