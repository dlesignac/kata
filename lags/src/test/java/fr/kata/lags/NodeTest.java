package fr.kata.lags;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NodeTest {

    private static Node root;
    private static Node a;
    private static Node b;
    private static Node c;
    private static Node d;
    private static Node e;
    private static Node f;

    @Before
    public void setUp() {
        root = Node.createRoot();
        a = new Node(Request.of("a 0 1 1"));
        b = new Node(Request.of("b 0 1 2"));
        c = new Node(Request.of("c 1 1 3"));
        d = new Node(Request.of("d 2 1 4"));
        e = new Node(Request.of("e 2 2 5"));
        f = new Node(Request.of("f 0 3 6"));
    }

    @Test
    public void insert_two_siblings() {
        root.insert(a);
        root.insert(b);

        assertThat(root.hasChild(a)).isTrue();
        assertThat(root.hasChild(b)).isTrue();
    }

    @Test
    public void insert_parent_and_child() {
        root.insert(a);
        root.insert(c);

        assertThat(root.hasChild(a)).isTrue();
        assertThat(a.hasChild(c)).isTrue();
    }

    @Test
    public void insert_parent_between_grandparent_and_child() {
        root.insert(a);
        root.insert(d);
        root.insert(c);

        assertThat(root.hasChild(a)).isTrue();
        assertThat(a.hasChild(c)).isTrue();
        assertThat(c.hasChild(d)).isTrue();
    }

    @Test
    public void insert_all() {
        root.insert(a);
        root.insert(b);
        root.insert(c);
        root.insert(d);
        root.insert(e);
        root.insert(f);

        assertThat(root.hasChild(a)).isTrue();
        assertThat(root.hasChild(b)).isTrue();
        assertThat(root.hasChild(f)).isTrue();
        assertThat(a.hasChild(c)).isTrue();
        assertThat(b.hasChild(c)).isTrue();
        assertThat(c.hasChild(d)).isTrue();
        assertThat(c.hasChild(e)).isTrue();
    }

    @Test
    public void childrenMaxGain_of_ab_should_return_2() {
        root.insert(a);
        root.insert(b);

        assertThat(root.childrenMaxGain()).isEqualTo(2);
    }

    @Test
    public void childrenMaxGain_of_acf_should_return_6() {
        root.insert(a);
        root.insert(c);
        root.insert(f);

        assertThat(root.childrenMaxGain()).isEqualTo(6);
    }

    @Test
    public void childrenMaxGain_of_acdf_should_return_8() {
        root.insert(a);
        root.insert(c);
        root.insert(d);
        root.insert(f);

        assertThat(root.childrenMaxGain()).isEqualTo(8);
    }

    @Test
    public void c_maxGain_of_cd_should_return_7() {
        root.insert(c);
        root.insert(d);

        assertThat(c.maxGain()).isEqualTo(7);
    }

    @Test
    public void root_maxGain_of_abcdef_should_return_10() {
        root.insert(a);
        root.insert(b);
        root.insert(c);
        root.insert(d);
        root.insert(e);
        root.insert(f);

        assertThat(root.maxGain()).isEqualTo(10);
    }

}
