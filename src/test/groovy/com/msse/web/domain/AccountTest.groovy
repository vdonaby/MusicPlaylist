package com.msse.web.domain

import com.msse.web.Repository.AccountRepository
import org.springframework.dao.DataIntegrityViolationException
import spock.lang.Specification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Unroll

import javax.validation.ConstraintViolationException

/**
 * Created by z001hk8 on 2/7/17.
 */

@Unroll
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountTest extends Specification {

    @Autowired
    AccountRepository accountRepository

    /*
    Requirement A1
     */
    def 'saves a valid account'() {

        given:

        def account = new Account(email: 'vdonaby@gmail.com', password: 'Password1', name: "Test Account")
        def startingAccountCount = accountRepository.count()

        when:
        account = accountRepository.save(account)

        then:
        account.id
        accountRepository.count() == startingAccountCount+ 1

        when:
        account = accountRepository.findOne(account.id)

        then:
        account.email == 'vdonaby@gmail.com'
        account.password == 'Password1'
        account.name == 'Test Account'

    }

    /*
    Requirement A2
     */
    def 'saves an account missing a email'() {

        given:
        def account = new Account(password: 'Password1', name: "Test Account")

        when:
        account = accountRepository.save(account)

        then:
        thrown(ConstraintViolationException)

    }

    /*
    Requirement A2
     */
    def 'saves an account missing a password'() {

        given:
        def account = new Account(email: 'testmissingpassword@gmail.com', name: "Test Account")
        def startingAccountCount = accountRepository.count()

        when:
        account = accountRepository.save(account)

        then:
        thrown(ConstraintViolationException)



    }

    /*
    Requirement A2
     */
    def 'saves an account missing a name'() {

        given:
        def account = new Account(email: 'testmissingname@gmail.com', password: 'Password1')

        when:
        account = accountRepository.save(account)

        then:
        thrown(ConstraintViolationException)

    }


    /*
    Requirement A3
     */
    def 'saves an account with a invalid password'() {

        given:
        def account = new Account(email: 'test@gmail.com', name: "Test Account", password: "test")

        when:
        account = accountRepository.save(account)

        then:
        thrown(ConstraintViolationException)

    }

    /*
    Requirement A4
     */
    def 'saves an account with a non-unique email'() {

        given:
        def account1 = new Account(email: 'notunique@gmail.com', name: "Test Account", password: "Password1")
        def account2 = new Account(email: 'notunique@gmail.com', name: "Test Account", password: "Password1")
        accountRepository.save(account1)

        when:
        accountRepository.save(account2)

        then:
        thrown(DataIntegrityViolationException)

    }

    /*
    Requirement A5
     */
    def 'saves password as encrypted data'() {

        given:
        def account = new Account(email: 'encryptedpassword@gmail.com', name: "Test Account", password: "Password1")
        def startingAccountCount = accountRepository.count()

        when:
        accountRepository.save(account)

        then:
        account.id
        accountRepository.count() == startingAccountCount + 1

        when:
        account = accountRepository.findOne(account.id)


        then:
        account.email == 'encryptedpassword@gmail.com'
        account.name == 'Test Account'
        account.password != 'Password1'




    }
}
