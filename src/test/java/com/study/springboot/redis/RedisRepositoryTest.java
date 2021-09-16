package com.study.springboot.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
public class RedisRepositoryTest {

    @Autowired
    private PersonRedisRepository repo;

    @Test
    void test() {
        Person person = new Person("Park", 20);

        // 저장
        repo.save(person);

        // `keyspace:id` 값을 가져옴
        repo.findById(person.getId());

        // Person Entity 의 @RedisHash 에 정의되어 있는 keyspace (people) 에 속한 키의 갯수를 구함
        System.out.println(repo.count());

        // 삭제
//        repo.delete(person);
//
//        System.out.println(person.getId());
//        System.out.println(repo.findById(person.getId()));
    }

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void testStrings() {
        // given
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String key = "stringKey";

        // when
        valueOperations.set(key, "hello");

        // then
        String value = valueOperations.get(key);
//        assertThat(value).isEqualTo("hello");
    }


    @Test
    void testSet() {
        // given
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        String key = "setKey";

        // when
        setOperations.add(key, "h", "e", "l", "l", "o");

        // then
        Set<String> members = setOperations.members(key);
        Long size = setOperations.size(key);

//        Assertions.assertEquals();

//        assertThat(members).containsOnly("h", "e", "l", "o");
//        assertThat(size).isEqualTo(4);
    }

    @Test
    void testHash() {
        // given
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        String key = "hashKey";

        // when
        hashOperations.put(key, "hello", "world");

        // then
        Object value = hashOperations.get(key, "hello");
//        assertThat(value).isEqualTo("world");

        Map<Object, Object> entries = hashOperations.entries(key);
//        assertThat(entries.keySet()).containsExactly("hello");
//        assertThat(entries.values()).containsExactly("world");

        Long size = hashOperations.size(key);
//        assertThat(size).isEqualTo(entries.size());
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void testStrings2() {
        final String key = "sabarada";

        final ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();

        stringStringValueOperations.set(key, "1"); // redis set 명령어
        final String result_1 = stringStringValueOperations.get(key); // redis get 명령어

        System.out.println("result_1 = " + result_1);

        stringStringValueOperations.increment(key); // redis incr 명령어
        final String result_2 = stringStringValueOperations.get(key);

        System.out.println("result_2 = " + result_2);
    }

    @Test
    void testList() {
        final String key = "sabarada";

        final ListOperations<String, String> stringStringListOperations = stringRedisTemplate.opsForList();

        stringStringListOperations.rightPush(key, "H");
        stringStringListOperations.rightPush(key, "e");
        stringStringListOperations.rightPush(key, "l");
        stringStringListOperations.rightPush(key, "l");
        stringStringListOperations.rightPush(key, "o");

        stringStringListOperations.rightPushAll(key, " ", "s", "a", "b", "a");

        final String character_1 = stringStringListOperations.index(key, 1);

        System.out.println("character_1 = " + character_1);

        final Long size = stringStringListOperations.size(key);

        System.out.println("size = " + size);

        final List<String> ResultRange = stringStringListOperations.range(key, 0, 9);

        System.out.println("ResultRange = " + Arrays.toString(ResultRange.toArray()));
    }
}
