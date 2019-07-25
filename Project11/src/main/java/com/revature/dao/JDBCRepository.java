package com.revature.dao;

import com.revature.bean.Employee;
import com.revature.bean.Reimbursement;
import com.revature.bean.ReimbursementEmployee;
import com.revature.bean.User;
import com.revature.service.ConnectionManager;
import com.revature.service.P1DataException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBCRepository {
    private final ConnectionManager manager;

    public JDBCRepository(ConnectionManager manager)
    {
        this.manager = manager;
    }

    public ArrayList<Reimbursement> findALLPendingReimbursement() {
        ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
        try(Connection c = manager.getConnection()) {
            String sql = "SELECT first_name, last_name,content,reimbursement_id,amount,reimbursement.status_id,status,created \n" +
                    "FROM reimbursement join the_user on the_user.user_id = reimbursement.user_id \n" +
                    "join reimbursement_status on reimbursement.status_id = reimbursement_status.status_id \n" +
                    "WHERE reimbursement.status_id = 1";
            PreparedStatement ps = c.prepareStatement(sql);


            ResultSet rs = ps.executeQuery();

            ;
            while(rs.next()) {
                Reimbursement currentReim = new Reimbursement(rs.getString("first_name")
                        ,rs.getString("last_name"),rs.getString("content")
                        ,rs.getInt("reimbursement_id"),rs.getDouble("amount")
                        ,rs.getInt("status_id"),rs.getString("status"),rs.getString("created"));
                list.add(currentReim);
            }


        } catch (SQLException e) {
            throw new P1DataException("Could not connect to database", e);
        }
        return  list;
    }

    public ArrayList<Reimbursement> findEmployeeReimbursement(String id) {
        ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
        try(Connection c = manager.getConnection()) {
            String sql = "SELECT first_name, last_name,content,reimbursement_id,amount,reimbursement.status_id,status,created \n" +
                    "FROM reimbursement join the_user on the_user.user_id = reimbursement.user_id \n" +
                    "join reimbursement_status on reimbursement.status_id = reimbursement_status.status_id \n" +
                    "WHERE the_user.user_id = " + id;
            PreparedStatement ps = c.prepareStatement(sql);


            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Reimbursement currentReim = new Reimbursement(rs.getString("first_name")
                        ,rs.getString("last_name"),rs.getString("content")
                        ,rs.getInt("reimbursement_id"),rs.getDouble("amount")
                        ,rs.getInt("status_id"),rs.getString("status"),rs.getString("created"));
                list.add(currentReim);
            }


        } catch (SQLException e) {
            throw new P1DataException("Could not connect to database", e);
        }
        return  list;
    }

    public ArrayList<Reimbursement> findALLReimbursement() {
        ArrayList<Reimbursement> list = new ArrayList<Reimbursement>();
        try(Connection c = manager.getConnection()) {
            String sql = "SELECT first_name, last_name,content,reimbursement_id,amount,reimbursement.status_id,status,created \n" +
                    "FROM reimbursement join the_user on the_user.user_id = reimbursement.user_id \n" +
                    "join reimbursement_status on reimbursement.status_id = reimbursement_status.status_id \n";
            PreparedStatement ps = c.prepareStatement(sql);


            ResultSet rs = ps.executeQuery();

            ;
            while(rs.next()) {
                Reimbursement currentReim = new Reimbursement(rs.getString("first_name")
                        ,rs.getString("last_name"),rs.getString("content")
                        ,rs.getInt("reimbursement_id"),rs.getDouble("amount")
                        ,rs.getInt("status_id"),rs.getString("status"),rs.getString("created"));
                list.add(currentReim);
            }


        } catch (SQLException e) {
            throw new P1DataException("Could not connect to database", e);
        }
        return list;
    }

    public void updateReimbursementStatus(String status, String id) {

        try(Connection c = manager.getConnection()) {
            String sql = "UPDATE reimbursement " +
                    "SET status_id = " + status +
                    " WHERE reimbursement_id =" + id;
            PreparedStatement ps = c.prepareStatement(sql);


            ps.executeUpdate();



        } catch (SQLException e) {
            throw new P1DataException("Could not connect to database", e);
        }

    }

    public ArrayList<Employee> findALLEmployees() {
        ArrayList<Employee> list = new ArrayList<Employee>();
        try(Connection c = manager.getConnection()) {
            String sql = "SELECT first_name,last_name,user_id,email " +
                    "FROM the_user " +
                    "WHERE is_employee_user = 'true'";

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ;
            while(rs.next()) {
                Employee currentEmployee = new Employee(rs.getString("first_name")
                        ,rs.getString("last_name"),rs.getInt("user_id")
                        ,rs.getString("email"));
                list.add(currentEmployee);
            }


        } catch (SQLException e) {
            throw new P1DataException("Could not connect to database", e);
        }
        return  list;
    }

    public User findByUsername(String username) {
        try(Connection c = manager.getConnection()) {
            String sql = "SELECT user_id, username, password, first_name, last_name, is_employee_user, email FROM the_user " +
                    "WHERE username = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            User user = null;
            while(rs.next()) {
                user = new User();
                user.setId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirst_Name(rs.getString("first_name"));
                user.setLast_Name(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setEmployee(rs.getBoolean("is_employee_user"));
                break;
            }
            return user;

        } catch (SQLException e) {
            throw new P1DataException("Could not connect to database", e);
        }
    }

    public void createRequestForm (int user_id, String content, double amount, String created) {
        try(Connection c = manager.getConnection()) {
            String sql = "INSERT INTO reimbursement (user_id, status_id, content, amount, created) " +
                    "VALUES (?, 1, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.setString(2, content);
            ps.setDouble(3, amount);
            ps.setString(4, created);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new P1DataException("Could not connect to database", e);
        }

    }

    public ArrayList<ReimbursementEmployee> getPendingStatus (int user_id) {
        try(Connection c = manager.getConnection()) {
            String sql = "SELECT content, amount, created, status FROM reimbursement NATURAL JOIN reimbursement_status " +
                    "WHERE user_id = ? and status_id = 1 order by reimbursement_id desc";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, user_id);

            ResultSet rs = ps.executeQuery();

            ArrayList<ReimbursementEmployee> arrayList = new ArrayList<>();
            while(rs.next()) {
                ReimbursementEmployee currentReim = new ReimbursementEmployee(rs.getString("content"),
                        rs.getDouble("amount"), rs.getString("created"), rs.getString("status"));

                arrayList.add(currentReim);
            }

            return arrayList;


        } catch (SQLException e) {
            throw new P1DataException("Could not connect to database", e);
        }
    }

    public ArrayList<ReimbursementEmployee> getResolvedStatus (int user_id) {
        try(Connection c = manager.getConnection()) {
            String sql = "SELECT content, amount, created, status FROM reimbursement NATURAL JOIN reimbursement_status " +
                    "WHERE user_id = ? and (status_id = 2 or status_id = 3) order by reimbursement_id desc";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, user_id);

            ResultSet rs = ps.executeQuery();

            ArrayList<ReimbursementEmployee> arrayList = new ArrayList<>();
            while(rs.next()) {
                ReimbursementEmployee currentReim = new ReimbursementEmployee(rs.getString("content"),
                        rs.getDouble("amount"), rs.getString("created"), rs.getString("status"));

                arrayList.add(currentReim);
            }

            return arrayList;


        } catch (SQLException e) {
            throw new P1DataException("Could not connect to database", e);
        }
    }

    public User findById(int user_id) {
        try(Connection c = manager.getConnection()) {
            String sql = "SELECT username, first_name, last_name, email FROM the_user " +
                    "WHERE user_id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, user_id);

            ResultSet rs = ps.executeQuery();

            User user = null;
            while(rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setFirst_Name(rs.getString("first_name"));
                user.setLast_Name(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                break;
            }
            return user;

        } catch (SQLException e) {
            throw new P1DataException("Could not connect to database", e);
        }
    }

    public void updateEmail (int user_id, String update) {
        try(Connection c = manager.getConnection()) {
            String sql = "UPDATE the_user SET email = ? WHERE user_id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, update);
            ps.setInt(2, user_id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new P1DataException("Could not connect to database", e);
        }
    }

    public void updateFirst (int user_id, String update) {
        try(Connection c = manager.getConnection()) {
            String sql = "UPDATE the_user SET first_name = ? WHERE user_id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, update);
            ps.setInt(2, user_id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new P1DataException("Could not connect to database", e);
        }
    }

    public void updateLast (int user_id, String update) {
        try(Connection c = manager.getConnection()) {
            String sql = "UPDATE the_user SET last_name = ? WHERE user_id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, update);
            ps.setInt(2, user_id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new P1DataException("Could not connect to database", e);
        }
    }

}
