package jpower.gradle

class Version {
    String version
    int major
    int minor
    int bugFix

    Version(String version) {
        this.version = version
        def split = version.tokenize(".")
        major = split[0] as int
        minor = split[1] as int
        bugFix = split[2] as int
    }

    @Override
    String toString() {
        "${major}.${minor}.${bugFix}"
    }

    Version increment() {
        if (bugFix == 9) {
            bugFix = 0
            minor++
        } else {
            bugFix++
        }
        return this
    }

    Version decrement() {
        if (bugFix == 0) {
            bugFix = 9
            minor--
        } else {
            bugFix--
        }

        this
    }

    Version next() {
        increment()
    }

    Version previous() {
        decrement()
    }

    boolean isRelease() {
        return major >= 2 && minor % 5 == 0
    }

    String getMaven() {
        if (release) {
            return toString()
        } else {
            return "${toString()}-SNAPSHOT"
        }
    }
}
