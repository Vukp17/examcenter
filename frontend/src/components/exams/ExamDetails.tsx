// ExamDetails.tsx
import React, { useContext, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Exam } from '../../models/Exam';
import ApiService from '../../services/ApiService';

function ExamDetails() {
  const [exam, setExam] = useState<Exam>();
  const { id } = useParams();
  const examId = parseInt(id);

useEffect(() => {
  async function fetchData() {
    const data = await ApiService.getExamById(examId);
    setExam(data);
  }
  fetchData();
}, []);

  if (!exam) {
    return <div>Exam not found</div>;
  }

  return (
    <div>
      <h1>{exam.field}</h1>
      <p>{exam.location}</p>
      <p>{exam.canceled}</p>
      <p>{exam.dateAndTime.toString()}</p>


      {/* Render other exam details */}
    </div>
  );
}

export default ExamDetails;

