import React, { useState, useEffect } from 'react';
import ApiService from '../../services/ApiService';
import { Exam } from '../../models/Exam';
import { ExamItem } from './exams';
export default function ExamList() {

  const [exams, setExams] = useState<Exam[]>([]);

  useEffect(() => {
    async function fetchData() {
      const data = await ApiService.getExams();
      setExams(data);
    }
    fetchData();
  }, []);

  async function handleExamDelete(examId) {
    try {
      await ApiService.deleteExam(examId);
      const data = await ApiService.getExams();
      setExams(data);
    } catch (error) {
      console.log(`An error occurred while deleting exam ${examId}: ${error.message}`);
    }
  }
  
  return (
    <div>
        <div className="list-group">
        {exams.map((exam) => (
        <ExamItem key={exam.id} exam={exam} onDelete={handleExamDelete} />
      ))}
      </div>
      
    </div>
  );
}






