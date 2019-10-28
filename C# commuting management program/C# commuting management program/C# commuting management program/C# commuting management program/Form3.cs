using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using MySql.Data;

namespace 출퇴근_관리
{
    public partial class Form3 : Form
    {
        MySqlConnection con = new MySqlConnection("Server=localhost;Database=login;Uid=root;Pwd=1234;");


        public Form3()
        {
            InitializeComponent();
            pictureBox1.Load(@"D:\c#\image\c1.png");
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
        }

        private void btsignup_Click(object sender, EventArgs e)
        {
           
            string insertQuery = "INSERT INTO login(name,position,department,userid,passwd) VALUES('" + NameBox.Text + "','" + positionbox.Text + "','" + departmentbox.Text + "','" + useridbox.Text + "','" + passwdbox.Text + "')";

            /*
            string connString = ConfigurationManager.ConnectionStrings["default"].ConnectionString;
            MySqlConnection conn = new MySqlConnection(connString);
            conn.Open();
            MySqlCommand comm = conn.CreateCommand();
            comm.CommandText = "INSERT INTO room(person,address) VALUES(@person, @address)";
            comm.Parameters.AddWithValue("@person", "Myname");
            comm.Parameters.AddWithValue("@address", "Myaddress");
            comm.ExecuteNonQuery();
            conn.Close();
             * 
             * 
             * try  
   {  
            string MyConnection2 = "datasource=localhost;port=3307;username=root;password=root";  
            string Query = "insert into student.studentinfo(idStudentInfo,Name,Father_Name,Age,Semester) values('" +this.IdTextBox.Text+ "','" +this.NameTextBox.Text+ "','" +this.FnameTextBox.Text+ "','" +this.AgeTextBox.Text+ "','" +this.SemesterTextBox.Text+ "');";  
            MySqlConnection MyConn2 = new MySqlConnection(MyConnection2);  
            MySqlCommand MyCommand2 = new MySqlCommand(Query, MyConn2);  
            MySqlDataReader MyReader2;  
            MyConn2.Open();  
            MyReader2 = MyCommand2.ExecuteReader();
            MessageBox.Show("Save Data");  
            while (MyReader2.Read())  
            {                     
            }  
            MyConn2.Close();  
        }  
        catch (Exception ex)  
        {   
            MessageBox.Show(ex.Message);  
         }  
             */
            con.Open();
            MySqlCommand command = new MySqlCommand(insertQuery, con);

            try 
            {
                
                if (command.ExecuteNonQuery() == 1)
                {
                    MessageBox.Show("회원가입 되었습니다.");
                }
                else
                {
                    MessageBox.Show("회원가입 실패했습니다.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }


            con.Close();
        }

        private void Form3_Load(object sender, EventArgs e)
        {

        }

        private void btnexit_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
            
        }
    }
}
