import React from 'react';
import { Exam } from '../../models/Exam';
import { Button } from 'primereact/button';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import ApiService from '../../services/ApiService';

interface ExamItemProps {
  exam: Exam;
  onDelete: (examId: number) => void;

}

export default function ExamItem({ exam, onDelete }: ExamItemProps) {

  const navigate = useNavigate();

  function handleSeeMore(examId) {
    console.log(`Clicked "See More" button for exam ID ${examId}`);
    navigate(`/exams/${examId}`);
  }

  async function handleDelete(examId) {
    await onDelete(examId);
  }
  
  return (

    <div className="marginContainer">
  <a href="#" key={exam.id} className="list-group-item list-group-item-action flex-column align-items-start w-100">
    <div className="d-flex justify-content-between">
      <h5 className="mb-1">{exam.field}</h5>
      <div>
        <Button label="See More" className="p-button p-button-warning p-mr-2" onClick={() => handleSeeMore(exam.id)} />
        <Button label="Delete" className="p-button p-button-danger" onClick={() => handleDelete(exam.id)} />
      </div>
    </div>
    <p className="mb-1">{exam.location}</p>
    <small>{exam.dateAndTime.toString()}</small>
  </a>
</div>


  );
}
