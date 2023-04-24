import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import ExamList from './components/exams/ExamList';
import 'primereact/resources/themes/saga-blue/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import ExamDetails from './components/exams/ExamDetails';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import Examinees from './components/exams/Examinees';
import Dashboard from './components/shared/dashboard';




const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    children: [
      {
        path: '/exams',
        element: <ExamList />,
      },
      {
        path:"exams/:id",
        element: <ExamDetails />
      },
      {
        path:"/exam-list",
        element: <Examinees />
      }
    ],
  },

]);

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
        <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
